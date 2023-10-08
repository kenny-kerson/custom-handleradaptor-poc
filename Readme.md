# WebMVC Custom HandlerAdaptor 구현하기
이 프로젝트는 1개의 api path로 들어오는 요청을, payload의 특정값을 참조하여, 해당 역할을 수행하는 Controller에 routing 해주는 기능구현을 목표로 한다.  

## Problem
1. 1개의 api path가 여러 역할을 수행하는 API가 있다.
2. 어플리케이션에서는 각 역할을 수행하는 controller method를 분리하고, api path의 payload에 따라 각각의 method가 호출되게 하고 싶다.
3. 이 코드들은 어플리케이션 로직에 영향을 주고 싶지 않다.

---

## Goal
1. WebMVC의 Custom HanlderAdaptor를 통해 1개의 api path를, 각 역할에 맞는 api path로 분리하여 routing 한다.
2. rounting을 할때, 요청으로 들어온 byte[]를 각각의 역할을 하는 api path의 payload에 맞게 serialization 한다.
3. 어플리케이션에서는, 라우팅 & serialzation에 대한 책임을 갖지 않고, payload에 따른 비지니스 로직만 처리한다.

---

## Requirements
**기능 요건**
1. 국내승인, 국내승인취소, 해외승인, 해외승인취소를 구현한다.
    - 각각의 기능은 서로 다른 payload를 갖는다.

**비기능 요건**
1. byte[]를 payload로 받는 1개의 API를 HandlerAdaptor를 통해, 국내승인 / 국내승인취소 등의 API로 routing 한다.
   - byte[]의 첫번째 3자리가 국내승인, 국내승인취소 등을 구분하는 구분자다.

---

## Context

---

## Solution

---

## Reference Materials