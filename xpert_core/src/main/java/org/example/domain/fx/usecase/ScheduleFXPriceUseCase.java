package org.example.domain.fx.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.openAPI.fx.GetFXPriceService;
import org.example.common.openAPI.fx.vo.FXItemVO;
import org.example.domain.fx.model.FXType;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.service.CommandFxDataService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.EnumUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleFXPriceUseCase {
    private final GetFXPriceService getFXPriceService;
    private final CommandFxDataService commandFxDataService;

    @Scheduled(cron = "0 0/30 * 1/1 * ? *")
    public void execute() {
        List<FXItemVO> fxItemList = getFXPriceService.getFXPrice();

        for (FXItemVO fxItem : fxItemList) {
            String unitName = fxItem.cur_unit().substring(0, 3);
            if (Arrays.stream(FXType.values()).anyMatch(v -> v.name().equals(unitName))) {
                commandFxDataService.saveFxData(FxData.builder()
                                .date(LocalDate.now())
                                .type(FXType.valueOf(fxItem.cur_unit().substring(0, 3)))
                                .price(parseStringPriceToInt(fxItem.bkpr()))
                                .sellPrice(parseStringPriceToInt(fxItem.ttb()))
                                .buyPrice(parseStringPriceToInt(fxItem.tts()))
                                .build()
                );
            }
        }
    }

    private int parseStringPriceToInt (String price) {
        return (int) Math.floor(Double.parseDouble(price.replace(",", "")));
    }
}
