package com.reporthub.coreapis.dtos.digital;




public record DsAcessToken(
                String access_token ,
                String expires_in,
                String token_type
){ }