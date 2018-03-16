-- auto create by SMD

use DB_SALESPLATFORM;

call pr_Drop_index_if_exists('T_USER','I_PK_T_USER');

create  index I_PK_T_USER on T_USER (C_BH);


use DB_SALESPLATFORM;

call pr_Drop_index_if_exists('T_ROLE','I_PK_T_ROLE');

create  index I_PK_T_ROLE on T_ROLE (C_BH);


use DB_SALESPLATFORM;

call pr_Drop_index_if_exists('T_RIGHT','I_PK_T_RIGHT');

create  index I_PK_T_RIGHT on T_RIGHT (C_BH);


use DB_SALESPLATFORM;

call pr_Drop_index_if_exists('T_USER_ROLE','I_PK_T_USER_ROLE');

create  index I_PK_T_USER_ROLE on T_USER_ROLE (C_BH);


use DB_SALESPLATFORM;

call pr_Drop_index_if_exists('T_ROLE_RIGHT','I_PK_T_ROLE_RIGHT');

create  index I_PK_T_ROLE_RIGHT on T_ROLE_RIGHT (C_BH);


use DB_SALESPLATFORM;

call pr_Drop_index_if_exists('T_GOODS','I_PK_T_GOODS');

create  index I_PK_T_GOODS on T_GOODS (C_BH);


use DB_SALESPLATFORM;

call pr_Drop_index_if_exists('T_ORDER','I_PK_T_ORDER');

create  index I_PK_T_ORDER on T_ORDER (C_BH);


use DB_SALESPLATFORM;

call pr_Drop_index_if_exists('T_CAR','I_PK_T_CAR');

create  index I_PK_T_CAR on T_CAR (C_BH);


use DB_SALESPLATFORM;

call pr_Drop_index_if_exists('T_COLLECTRION','I_PK_T_COLLECTRION');

create  index I_PK_T_COLLECTRION on T_COLLECTRION (C_BH);


use DB_SALESPLATFORM;

call pr_Drop_index_if_exists('T_MESSAGE','I_PK_T_MESSAGE');

create  index I_PK_T_MESSAGE on T_MESSAGE (C_BH);


use DB_SALESPLATFORM;

call pr_Drop_index_if_exists('T_NEWS','I_PK_T_NEWS');

create  index I_PK_T_NEWS on T_NEWS (C_BH);


use DB_SALESPLATFORM;

call pr_Drop_index_if_exists('T_TIPS','I_PK_T_TIPS');

create  index I_PK_T_TIPS on T_TIPS (C_BH);


use DB_SALESPLATFORM;

call pr_Drop_index_if_exists('T_ACTTIP','I_PK_T_ACTTIP');

create  index I_PK_T_ACTTIP on T_ACTTIP (C_BH);


