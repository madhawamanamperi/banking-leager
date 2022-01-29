package com.bl.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResponse {
    private boolean valid;
    private String message;
    private Object data;
}
