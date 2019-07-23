package pablo.barrientos.utng.edu.mx.androidjson;

/**
 * Created by Pablo Barrientos on 08/04/2018.
 */

public class Config {
    //Agregando las direcciones de nuestros scripts de el CRUD
    public static final String URL_ADD="https://unending-multiplex.000webhostapp.com/addEmp.php";
    public static final String URL_GET_ALL = "https://unending-multiplex.000webhostapp.com/getAllEmp.php";
    public static final String URL_GET_EMP = "https://unending-multiplex.000webhostapp.com/getEmp.php?id=";
    public static final String URL_UPDATE_EMP = "https://unending-multiplex.000webhostapp.com/updateEmp.php";
    public static final String URL_DELETE_EMP = "https://unending-multiplex.000webhostapp.com/deleteEmp.php?id=";

    //Definiendo las constants para ser usadas en los requerimientos a los scripts de PHP
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAME = "name";
    public static final String KEY_EMP_DESG = "desg";
    public static final String KEY_EMP_SAL = "salary";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_DESG = "desg";
    public static final String TAG_SAL = "salary";

    public static final String EMP_ID = "emp_id";
}
