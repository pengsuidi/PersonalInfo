package com.amaker.personalinfo.util;

import okhttp3.MediaType;

public class Config {
    public static final String FILE_PREFERENCE = "preference";
    public static final String IF_Seller = "ifseller";
    public static final String FOOD_TYPE = "foodtype";
    public static final String SETTTING_REMEMBER = "setting_remember";
    public static final String SETTTING_AUTO_LOGIN = "setting_auto_login";
    public static final String DELETE_FOOD_ID = "delete_food_id";
    public static final String DATA_USERNAME = "data_username";
    public static final String DATA_PASSWORD = "data_password";
    public static final String FOOD_MENU_INFO = "food_menu_info";
    public static final String FOOD_INFO_LIST = "food_info_list";
    public static final String FOOD_NAME_LIST = "food_name_list";
    public static final String FOOD_ID_LIST = "food_id_list";
    public static final String DELETE_FOOD_MENU_POSITON = "delete_food_menu_position";

    //请求方式常量
    public static final String HTTP_GET = "GET";
    public static final String HTTP_POST = "POST";

    //请求状态码常量
    public static final int STATUS_ERROR = -1;
    public static final int STATUS_OK = 200;
    public static final int STATUS_FAILURE = 0;
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAVOURTIE_SUCCESS = 100;
    public static final int STATUS_ADD =150 ;
    public static final int STATUS_MINUS =149 ;
    public static final int FOOD_TYPE_NAME =151 ;
    public static final int SEND2FRAGMENT =153 ;
    public static final int ADD_FOOD =153 ;
    public static final int DEL_FOOD =154;
    public static final int DELETE =155;
    //请求参数名常量
    public static final String REQUEST_PARAMETER_SHOPNAME ="shopname";
    public static final String REQUEST_PARAMETER_FOOD_ID_STRING ="food_id_string";
    public static final String REQUEST_PARAMETER_FOOD_MENU_obj ="food_menu_obj";
    public static final String REQUEST_PARAMETER_SHOPTYPE ="shoptype";

    public static final String REQUEST_QUERY_STRING = "query_string";
    public static final String REQUEST_PARAMETER_SHOP_ID = "shopid";
    public static final String REQUEST_PARAMETER_COMMENT = "comment";
    public static final String REQUEST_PARAMETER_COMMENT_ADDR = "comment_addr";
    public static final String REQUEST_PARAMETER_USER_ID = "userid";
    public static final String REQUEST_PARAMETER_FOOD_NAME = "foodname";
    public static final String REQUEST_PARAMETER_FOOD_DESCRIPTION = "food_description";
    public static final String REQUEST_PARAMETER_USER_PIC_ADDR = "userpicaddr";
    public static final String REQUEST_PARAMETER_USER_PIC = "userpic";
    public static final String REQUEST_PARAMETER_OID = "oid";
    public static final String REQUEST_PARAMETER_NEWOID = "newoid";
    public static final String REQUEST_PARAMETER_OLDOID = "oldoid";
    public static final String REQUEST_PARAMETER_TOTAL_PRICE = "totalprice";
    public static final String REQUEST_PARAMETER_UserIMG_BASE64 ="userimg_base64";
    public static final String REQUEST_PARAMETER_FOOD_IMG_64 ="foodimg64";

    public static final String REQUEST_PARAMETER_GRADE ="grade";
    public static final String REQUEST_PARAMETER_COMMENT_ID ="comment_id";

    //请求参数值常量
    public static final String REQUEST_VALUE_METHOD_LIST_BY_PAGE = "list_by_page";
    public static final String REQUEST_VALUE_METHOD_LIST = "list";
    public static final String REQUEST_VALUE_METHOD_ONE = "one";
    public static final String REQUEST_VALUE_METHOD_SEARCH = "search";
    public static final int REQUEST_VALUE_PAGE_SIZE = 10;
    public static final int Delete_food_menu = 222;
    public static final int updateImg_food_menu = 223;
    public static final int Upload_food_menu = 111;

    //请求地址常量
    ///42.193.105.80      192.168.126.1 42.193.105.80
    public static final String URL_GetShopInfoByName = "http://42.193.105.80:8080/ServletTest/GetShopInfoByName";//获得店铺信息by shopname
    public static final String URL_BecomeSeller = "http://42.193.105.80:8080/ServletTest/BecomeSeller";
    public static final String URL_DELETE_BOUGHTFOOD = "http://42.193.105.80:8080/ServletTest/deleteBoughtFood";
    public static final String URL_GET_SHOPPINGCAR = "http://42.193.105.80:8080/ServletTest/GetShoppingcarServlet";
    public static final String URL_GetShopInfoByUserid = "http://42.193.105.80:8080/ServletTest/GetShopInfoByUserIDServlet";
    public static final String URL_GetShopInfoByShopidServlet = "http://42.193.105.80:8080/ServletTest/GetShopInfoByShopidServlet";
    public static final String URL_GetRandomShopServlet = "http://42.193.105.80:8080/ServletTest/GetRandomShopServlet";
    public static final String URL_GetFoodInfoServlet = "http://42.193.105.80:8080/ServletTest/GetFoodInfoServlet";
    public static final String URL_BUY_FOOD = "http://42.193.105.80:8080/ServletTest/buyfood";
    public static final String URL_FIND_SHOP_BYFOODNAME = "http://42.193.105.80:8080/ServletTest/FindShopByfoodnameServlet";
    public static final String URL_UPLOAD_COMMENT = "http://42.193.105.80:8080/ServletTest/UpdateUserCommentServlet";
    public static final String URL_COMMENT_SHOPINFO = "http://42.193.105.80:8080/ServletTest/CommentShopInfo";//获得店铺信息by shopid
    public static final String URL_GET_COMMENT = "http://42.193.105.80:8080/ServletTest/GetCommentServlet";
    public static final String URL_UPLOAD_FAVOURTIE = "http://42.193.105.80:8080/ServletTest/uploadFavouriteServlet";
    public static final String URL_IF_FAVOURITE = "http://42.193.105.80:8080/ServletTest/IfFavourite";
    public static final String URL_GET_FAVOURITE_LIST = "http://42.193.105.80:8080/ServletTest/GetFavouriteListServlet";
    public static final String URL_DELETE_FAVOURITE = "http://42.193.105.80:8080/ServletTest/deleteFavouriteServlet";
    public static final String URL_MINUS_FOOD = "http://42.193.105.80:8080/ServletTest/minusFood";
    public static final String URL_GET_ORDERS = "http://42.193.105.80:8080/ServletTest/GetOrdersServlet";
    public static final String URL_GET_ORDERS_FOOD = "http://42.193.105.80:8080/ServletTest/GetOrdersFoodServlet";
    public static final String REQUEST_PARAMETER_FOOD_PRICE ="foodprice" ;
    public static final String REQUEST_PARAMETER_FOOD_TYPE ="foodtype" ;
    public static final String SELECT_PASSWORD = "http://42.193.105.80:8080/ServletTest/selectPassword";
    public static final String SELECT_BIRTHDAY = "http://42.193.105.80:8080/ServletTest/selectBirthday";
    public static final String UPDATE_PASSWORD ="http://42.193.105.80:8080/ServletTest/updatePassword" ;
    public static final String UPDATE_BIRTHDAY = "http://42.193.105.80:8080/ServletTest/updateBirthday";
    public static final String UPDATE_NICKNAME ="http://42.193.105.80:8080/ServletTest/updateNickname" ;
    public static final String URL_GetUserInfo ="http://42.193.105.80:8080/ServletTest/GetUserInfoServlet" ;
    public static final String URL_DeleteComment ="http://42.193.105.80:8080/ServletTest/DeleteCommentServlet" ;
    public static final String URL_UPDATE_SHOP ="http://42.193.105.80:8080/ServletTest/UploadShopServlet" ;
    public static final String URL_UPLOAD_FOOD ="http://42.193.105.80:8080/ServletTest/UploadFoodServlet" ;
    public static final String URL_GET_QUERY_RES ="http://42.193.105.80:8080/ServletTest/GetQueryResultServlet" ;
    public static final String URL_Upload_User_Img="http://42.193.105.80:8080/ServletTest/UploadUserImgServlet" ;




    public static final String REQUEST_PARAMETER_USERNAME = "uname";
    public static final String REQUEST_PARAMETER_USERID = "userid";
    public static final String REQUEST_PARAMETER_PASSWORD = "upassword";
    public static final String REQUEST_PARAMETER_SHOPIMG_BASE64 ="shopimg_base64";
    public static final String REQUEST_PARAMETER_CommentIMG_BASE64 ="commentimg_base64";
    public static final String LOG_TAG_INFO = "Info";
    //请求参数值常量

    //请求地址常量
    public static final String URL_LOGIN = "http://42.193.105.80:8080/ServletTest/loginServlet";
    public static final String URL_REGISTER = "http://42.193.105.80:8080/ServletTest/registerServlet";
    public static final String URL_FOOD = "http://42.193.105.80:8080/ServletTest/food";
    public static final String URL_PAY = "http://42.193.105.80:8080/ServletTest/pay";
    public static final String URL_PAYMENT = "http://42.193.105.80:8080/ServletTest/payment";
    public static final String URL_GET_PAYPASSWORD ="http://42.193.105.80:8080/ServletTest/GetPayPasswordServlet" ;
    public static final String URL_GET_OID ="http://42.193.105.80:8080/ServletTest/GetOIDServlet" ;
    public static final String URL_UPLOAD_OID ="http://42.193.105.80:8080/ServletTest/UploadOidServlet" ;

    public static final String URL_UPDATE_PAYMENT = "http://42.193.105.80:8080/ServletTest/UploadPaymentServlet" ;
    public static final String URL_SELECT_PAYPASSWORD = "http://42.193.105.80:8080/ServletTest/selectPayPassword" ;
    public static final String URL_UPDATE_PAYPASSWORD = "http://42.193.105.80:8080/ServletTest/updatePayPassword" ;
    public static final String URL_GetSellerInfo = "http://42.193.105.80:8080/ServletTest/GetSellerInfo" ;
    public static final String URL_IfSeller = "http://42.193.105.80:8080/ServletTest/IfSeller" ;
    public static final String URL_GetPersonCommentsServlet = "http://42.193.105.80:8080/ServletTest/GetPersonCommentsServlet" ;


}
