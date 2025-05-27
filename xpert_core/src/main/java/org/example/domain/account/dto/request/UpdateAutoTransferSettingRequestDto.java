package org.example.domain.account.dto.request;

public record UpdateAutoTransferSettingRequestDto(
    Boolean autoTransfer,

    int autoTransferAmount
) {
}
