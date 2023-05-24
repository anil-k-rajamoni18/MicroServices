package com.reporthub.coreapis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
public record DSAcessToken(
                String access_token ,
                String expires_in,
                String grant_type
){ }