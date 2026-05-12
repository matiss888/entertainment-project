
package com.matiss.entertainment_storage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegUserResponse {
    private String token;
    private String username;
}