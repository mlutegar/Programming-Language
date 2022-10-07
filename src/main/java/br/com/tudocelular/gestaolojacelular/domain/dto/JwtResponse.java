package br.com.tudocelular.gestaolojacelular.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@Builder
public class JwtResponse implements Serializable {
    private final String jwtToken;
}