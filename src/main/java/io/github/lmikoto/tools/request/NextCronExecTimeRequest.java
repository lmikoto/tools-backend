package io.github.lmikoto.tools.request;

import lombok.Data;

@Data
public class NextCronExecTimeRequest {

    private String cron;

    private Integer num;
}
