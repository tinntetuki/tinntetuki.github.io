/*
 * Copyright 1999-2018 tinntetuki Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tinntetuki.data.bean;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;

/**
 * @author tinntetuki
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TickerBO implements Comparable, Serializable {
    private String name;
    private Double value;

    public int compareTo(@NotNull TickerBO o) {
        return this.value - o.value > 0 ? 1 : this.value - o.value == 0 ? 0 : -1;
    }

    @SneakyThrows
    @Override
    public int compareTo(@NotNull Object o) {
        if(!(o instanceof TickerBO)){
            throw new Exception();
        }
        return this.value - ((TickerBO)o).value > 0 ? 1 : this.value - ((TickerBO)o).value == 0 ? 0 : -1;
    }
}
