package com.reporthub.coreapis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DSAcessToken {
    private String access_token;
    private String expires_in;
    private String token_type;
}
