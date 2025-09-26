/*
 * CREATE DATABASE : 새로운 데이터베이스 (저장공간)을 생성하는 명령어이다. 
 * 데이터베이스 이름은 일반적으로 프로젝트명이나 서비스명을 따르먀
 * 다른 데이터베이스와 중봇되지 않는 고유한 이름이어야 한다.
 * IF NOT EXISTS(선택사항) 만약 같은 이름의 데이터베이스가 없을 때만 생성하도록 하여 오류를 방지한다. 
 * */
create database if not exists WANTED_LMS;

show databases;

use WANTED_LMS;

show TABLES;

/*
 * create user : 새로운 사용자를 생성하는 명령어.
 * "gorilla"@"%" : 사용자 계정을 정의한다.
 * - gorilla : 생성할 사용자 아이디
 * - @"%" : 이 사용자가 접속할 수 있는 위치(호스트)지정
 * IDENTIFIED BY "gorilla" : 사용자의 비밀번호를 "gorilla"로 설정함.
 * */
create user "gorilla"@"%" IDENTIFIED by "gorilla";

/*
 * GRANT : 사용자에게 특정 권한을 부여하는 명령어.
 * ALL PRIVILEGES : 데이터베이스를 제어하는 거의 모든 권한(생성, 수정, 삭제 조회 등)을 의미
 * ON WANTED_LMS.*(TABLE) : 권한을 적용한 대상을 지정
 * - "WANTED_LMS" 데이터베이스의 '*'(모든 테이블)을 의미
 * TO "gorilla"@"%" 권한을 받을 사용자를 지정
 * */
grant all privileges on WANTED_LMS.* to "gorilla"@"%";

FLUSH privileges; 





