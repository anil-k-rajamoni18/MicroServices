package com.codealien.user.VO;

import com.codealien.user.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {

    private Person user;
    private Department department;
    private  String errorDes;

}
