package com.minibank.accounts.model.dtos;

import lombok.Builder;

@Builder
public record ResponseDTO(String statusCode,String statusMsg) {
}
