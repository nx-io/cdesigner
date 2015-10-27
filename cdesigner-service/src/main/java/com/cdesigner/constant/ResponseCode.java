package com.cdesigner.constant;

public enum ResponseCode {

    UNAUTHORIZED(401),

    FORBIDDEN(403),

    SERVER_ERROR(500),

    // Common error code 10000-19999
    INVALID_PARAMETER(10000),

    FILE_IS_EMPTY(10100),

    FILE_TYPE_INCORRECT(10101),

    FILE_BEYOND_MAXSIZE(10102),

    FILE_ABSENT_MINSIZE(10103),

    IMAGE_BEYOND_MAXWIDTH(10104),

    IMAGE_BEYOND_MAXHEIGHT(10105),

    IMAGE_ABSENT_MINWIDTH(10106),

    IMAGE_ABSENT_MINHEIGHT(10107),

    IMAGE_VALIDATE_ERROR(10108),

    FILE_UPLOAD_ERROR(10109),

    IMAGE_PATH_FORMAT_INCORRECT(10110),

    LOCATION_NOT_EXIST(10200),

    STARTUP_STATUS_NOT_EXIST(10210),

    STARTUP_ROLE_NOT_EXIST(10220),

    INDUSTRY_DOMAIN_NOT_EXIST(10230),

    PROJECT_PHASE_NOT_EXIST(10240),

    TEAM_SIZE_NOT_EXIST(10250),

    FINANCING_PHASE_NOT_EXIST(10260),

    /* account related error code 20000-29999 */
    ACCOUNT_NOT_EXIST(20000),

    ACCOUNT_OR_PASSWORD_INCORRECT(20001),

    ACCOUNT_INACTIVE(20002),

    EMAIL_REGISTERED(20003),

    MOBILE_REGISTERED(20004),

    GET_3RD_OPENID_ERROR(20005),

    GET_3RD_USER_INFO_ERROR(20006),

    CODE_INCORRECT(20100),

    SMS_BEYOND_DAILY_LIMIT(20101),

    SMS_SEND_FAILED(20102),

    OLD_PASSWORD_INCORRECT(20200),

    USER_NOT_EXIST(20300),

    DEMAND_NOT_EXIST(30000),

    DEMAND_NOT_BELONG_CURRENTUSER(30001),

    PROJECT_NOT_EXIST(30100),

    PROJECT_NOT_BELONG_CURRENTUSER(30101),

    CONTENT_NOT_EXIST(30200),

    COURSE_NOT_EXIST(30300),

    QUESTION_NOT_EXIST(30400),

    QUESTION_CATEGORY_NOT_EXIST(30401),

    TUTOR_NOT_EXIST(30402),

    QUESTION_CANNOT_ANSWER(30403),

    PIONEER_PARK_NOT_EXIST(30500),

    INVEST_ORG_NOT_EXIST(30600),

    CONTEST_NOT_EXIST(30700),

    CONTEST_ENTRY_NOT_EXIST(30800),

    CAMPAIGN_NOT_EXIST(30900),

    ;

    private int value;

    private ResponseCode(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}