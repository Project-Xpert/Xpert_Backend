package org.example.domain.account.dto.response;

import org.example.domain.account.spi.vo.AccountListItemVO;

import java.util.List;

public record GetAccountListResponseDto(
    List<AccountListItemVO> deposits,

    List<AccountListItemVO> savings,

    List<AccountListItemVO> expiredAccounts,

    List<AccountListItemVO> overdueAccounts
) {
}
