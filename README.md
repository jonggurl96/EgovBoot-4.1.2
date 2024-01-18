# EgovBoot-4.1.2
전자정부프레임워크 공통컴포넌트 4.1.2 Spring Boot 버전

## 프로젝트 구조

### src/main/java
```text
egovframework
   ㄴ ablyr --------------------------------- Abstract Layer, 계층형 구조로 구성
   ㄴ com ------------------------------------ 공통컴포넌트
      ㄴ cmm --------------------------------- 공통컴포넌트 범용
      ㄴ utl --------------------------------- 공통컴포넌트 유틸
   ㄴ conf ----------------------------------- 설정파일
   ㄴ main ----------------------------------- EgovBootApplication.java
   ㄴ util ----------------------------------- 유틸리티
```
### Architecture
```mermaid
sequenceDiagram
    title Select Flow
    actor User
    participant View
    participant Controller
    participant Service
    participant Mapper
    participant DataBase
    
    User ->> View: action
    View ->> Controller: URL, Params
    Controller ->> Service: SearchDTO
    Service ->> Mapper: SearchDTO
    Mapper ->> DataBase: SQL
    
    DataBase ->> Mapper: Columns
    Mapper ->> Service: DTO
    Service ->> Controller: DTO
    Controller ->> View: HTML, VO
    View ->> User: HTML

```

```mermaid
sequenceDiagram
    title Insert/Update/Delete
    actor User
    participant View
    participant Controller
    participant Service
    participant Mapper
    participant DataBase
    
    User ->> View: action
    View ->> Controller: URL, Params
    Controller ->> Service: VO
    Service ->> Mapper: VO
    Mapper ->> DataBase: SQL
    
    DataBase --> Mapper: -
    Mapper --> Service: -
    Service --> Controller: -
    Controller ->> View: HTML, VO
    View ->> User: HTML
```




# CKEditor

https://www.codingfactory.net/13253

# 제외한 라이브러리

- ajaxtags-resources: JSP Ajax 관련 Tag
- xbean: XML 스키마로 Bean 생성
- javaparser-core: Java 1.8까지만 지원 가능
- taglibs-standart-impl: JSTL

# Plugin 수정

> maven-war-plugin -> maven-jar-plugin  
> cargo-maven3-plugin 주석

