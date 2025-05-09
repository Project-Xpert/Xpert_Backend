package org.example.domain.fx.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.fx.model.FxType;
import org.example.domain.fx.model.FxData;
import org.example.domain.fx.service.CommandFxDataService;
import org.example.domain.fx.service.GetFxDataService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ScheduleDeleteFXPriceUseCase {
    private final GetFxDataService getFxDataService;
    private final CommandFxDataService commandFxDataService;

    @Scheduled(cron = "0 0 0 1/1 * ?")
    public void execute() {
        LocalDate date = LocalDate.now().minusDays(10);

        for (FxType fxType: FxType.values()) {
            FxData fxData = getFxDataService.getFxDataByLocalDateAndFxType(date, fxType);
            commandFxDataService.delete(fxData);
        }
    }
}
