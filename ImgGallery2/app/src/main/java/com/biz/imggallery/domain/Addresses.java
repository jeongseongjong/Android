package com.biz.imggallery.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

// seriralizable
// spring web에서 보내는 데이터는 모두가 문자열로 Charequence방식으로
// 일렬 종대로 전달된다.
// ModelAndAttribute로 받을 때는 Serializable로 인터페이스를 implement한
// vo로  받아야 한다.
// spring web에서는 선택사항으로 설정하면 되고
// 안드로이드에서는 반드시 vo 클래스에 Serializable을 implement해주어야만
// Intent간에 객체에 값을 담아서 전달할 수 있다.
public class Addresses implements Serializable {

    private String a_name;
    private String a_tel;
    private String a_addr;
}
