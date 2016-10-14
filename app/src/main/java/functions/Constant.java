package functions;

/**
 * Created by swati on 2/10/15.
 */
public interface Constant {

    String CROSSLINKS = "crosslinks";
    String COLLEGESPACE = "collegespace";
    String BULLET = "bullet";
    String JUNOON = "junoon";
    String ROTARACT = "rotaract";
    String CSI = "csi";
    String IEEE = "ieee";
    String DEB = "debsoc";
    String QUIZ = "quiz";
    String ASHWA = "ashwa";
    String ENACTUS = "enactus";
    String AAGAZ = "aagaz";

    String SOCIETY_SET = "set";
    String SOCIETY_ITEM_CHANGED = "item_changed";

    String IMAGE = "img";
    String DES = "dec";
    String LIKE = "like";
    String LINK = "link";
    String OBID = "oid";

    String LOCATION_LAT = "LocationLat";
    String LOCATION_LON = "LocationLong";
    String LOCATION_NAME = "LocationName";
    String LOCATION_ICON = "LocationIcon";

    String CALENDAR_BRANCH = "cal_branch";
    String CALENDAR_SEM = "cal_sem";
    String CALENDAR_SECTION = "cal_sec";
    String IS_CLASS_SET = "classset";
    String IS_TIME_TABLE_CHANGED = "timetablechanged";
    String GET_TIME_TABLE = "timetable";

    String TIMETABLE_API = "http://nsitonline.in/NSITconnect/tt2/api/get-data.php?";

    String id = "109315262061";


    String common_access = "CAAGZAwVFNCKgBAANhEYok6Xh7Q7UZBeTZCUqwPDLYhRZCmNn0igI8SE339jSn2zjxCpA1JUmXH" +
            "m55XKVXslhdKKoTF3b5sLsiZBVd0ylYwX3MIGOnRyzn0T2XVywwoPKP7ML9WZCqELGRuIGxoM8ia05CiUiqcbgsb4wzTuBKkvKaqb7TPt2VnPtpr" +
            "RZBWda4kZD";
    String id_nsitonline = "109315262061",
            id_crosslinks = "184835371535420",
            id_collegespace = "252117054812001",
            id_bullet = "109582689081817";
    String id_junoon = "158168947539641",
            id_rotaract = "604809706256620",
            id_debsoc = "376394819102290",
            id_ieee = "278952135548721",
            id_csi = "126976547314225",
            id_quiz = "185960271431856",
            id_ashwa = "135639763273290",
            id_enactus = "499766883378107",
            id_aagaz = "1457237581165961";

    String[] sem = {"Semester", "Sem 1", "Sem 2", "Sem 3", "Sem 4", "Sem 5", "Sem 6", "Sem 7", "Sem 8"};
    String[] branch = {"Branch", "COE", "IT", "ECE", "ICE", "MPAE", "BT"};

    String subjects = "{\n" +
            "\t\"it\" : [\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"humanities\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 101, \"name\" : \"Humanities\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 102, \"name\" : \"Mathematics I\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 103, \"name\" : \"Physics I\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 104, \"name\" : \"Chemistry\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"applied\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 105, \"name\" : \"Manufacturing Processes\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"core\" : [],\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 101, \"name\" : \"Humanities\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 102, \"name\" : \"Mathematics I\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 103, \"name\" : \"Physics I\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 104, \"name\" : \"Chemistry\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 105, \"name\" : \"Manufacturing Processes\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 106, \"name\" : \"Engineering Drawing T\", \"credits\" : 3},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 107, \"name\" : \"Physics I\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 108, \"name\" : \"Chemistry\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 109, \"name\" : \"Workshop I\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 29,\n" +
            "\t\t\"semester\" : 1\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"humanities\" : [],\n" +
            "\t\t\t\"applied\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 111, \"name\" : \"Principles of Electrical Engg\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 112, \"name\" : \"Mechanical Sciences\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 113, \"name\" : \"Engineering Mathematics I\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 115, \"name\" : \"Discrete Structures\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"core\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 114, \"name\" : \"Introduction to Programming\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 111, \"name\" : \"Principles of Electrical Engg\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 112, \"name\" : \"Mechanical Sciences\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 113, \"name\" : \"Engineering Mathematics I\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 114, \"name\" : \"Introduction to Programming\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 115, \"name\" : \"Discrete Structures\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 116, \"name\" : \"Principles of Electrical Science Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 117, \"name\" : \"Mechanical Sciences Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 118, \"name\" : \"Introduction to Programming Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 119, \"name\" : \"Linux/UNIX Lab\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 28,\n" +
            "\t\t\"semester\" : 2\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 201, \"name\" : \"Data Structures\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 202, \"name\" : \"Digital Circuits and Systems\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 203, \"name\" : \"Analog Electronics\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 204, \"name\" : \"Engineering Mathematics - II\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 205, \"name\" : \"Organizational Management\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 206, \"name\" : \"Data Structures Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 208, \"name\" : \"Digital Circuits and Systems Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 209, \"name\" : \"Analog Electronics\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 210, \"name\" : \"Programming I Lab\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 27,\n" +
            "\t\t\"semester\" : 3\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 211, \"name\" : \"System Analysis and Design\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 212, \"name\" : \"Analog and Digital Communication\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 213, \"name\" : \"Operating Systems\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 214, \"name\" : \"Computer Graphics\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 215, \"name\" : \"Computer System Architecture\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 216, \"name\" : \"System Analysis and Design Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 217, \"name\" : \"Analog and Digital Communication Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 218, \"name\" : \"Operating Systems Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 219, \"name\" : \"Computer Graphics Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR5\", \"code\" : 220, \"name\" : \"Computer System Architecture Lab\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 30,\n" +
            "\t\t\"semester\" : 4\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 301, \"name\" : \"Design and Analysis of Algorithms\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 302, \"name\" : \"Object Oriented Technology\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 303, \"name\" : \"Microprocessors and Applications\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 304, \"name\" : \"Relational Database Management Systems\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 305, \"name\" : \"Computer Networks\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 307, \"name\" : \"Microprocessor Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 308, \"name\" : \"RDBMS Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 308, \"name\" : \"Networking Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 309, \"name\" : \"Technical and Business Communication\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 27,\n" +
            "\t\t\"semester\" : 5\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 311, \"name\" : \"Multimedia and Applications\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 312, \"name\" : \"Software Engineering\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 313, \"name\" : \"Information Technology and Coding Techniques\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 314, \"name\" : \"Elective - I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 315, \"name\" : \"Microwave and Satellite Communication\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 316, \"name\" : \"Multimedia Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 317, \"name\" : \"Software Engineering Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 318, \"name\" : \"Practical Training\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 319, \"name\" : \"Microwave and Satellite Communication Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 320, \"name\" : \"Advanced Programming Lab\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 29,\n" +
            "\t\t\"semester\" : 6\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 401, \"name\" : \"Internet and Web Engineering\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 402, \"name\" : \"Distributed Systems and Computing\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 403, \"name\" : \"Compiler and Translator Design\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 404, \"name\" : \"Elective - II\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 405, \"name\" : \"Advances in Digital System Design\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 406, \"name\" : \"Internet and Web Engineering Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 407, \"name\" : \"Distributed Systems and Computing Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 408, \"name\" : \"Elective II Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 409, \"name\" : \"Compiler and Translator Design Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 410, \"name\" : \"Practical Training\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"VS2\", \"code\" : 411, \"name\" : \"Minor Project\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 34,\n" +
            "\t\t\"semester\" : 7\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 412, \"name\" : \"Information Security\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 413, \"name\" : \"Financial and Cost Management\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 414, \"name\" : \"Elective III\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 415, \"name\" : \"Elective III Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 416, \"name\" : \"Major Project\", \"credits\" : 8},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 417, \"name\" : \"Practical Training\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 418, \"name\" : \"Seminar Reports\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 28,\n" +
            "\t\t\"semester\" : 8\n" +
            "\t}\n" +
            "\t],\n" +
            "\t\"coe\" : [\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"humanities\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 101, \"name\" : \"Humanities\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 102, \"name\" : \"Mathematics I\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 103, \"name\" : \"Physics I\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 104, \"name\" : \"Chemistry\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"applied\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 105, \"name\" : \"Manufacturing Processes\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"core\" : [],\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 101, \"name\" : \"Humanities\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 102, \"name\" : \"Mathematics I\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 103, \"name\" : \"Physics I\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 104, \"name\" : \"Chemistry\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 105, \"name\" : \"Manufacturing Processes\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 106, \"name\" : \"Engineering Drawing T\", \"credits\" : 3},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 107, \"name\" : \"Physics I\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 108, \"name\" : \"Chemistry\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 109, \"name\" : \"Workshop I\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 29,\n" +
            "\t\t\"semester\" : 1\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"humanities\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 113, \"name\" : \"Mathematics II\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 115, \"name\" : \"Physics of Materials\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"applied\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 111, \"name\" : \"Principles of Electrical Engg\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 112, \"name\" : \"Applied Mechanics\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"core\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 114, \"name\" : \"Introduction to Programming\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 111, \"name\" : \"Principles of Electrical Engg\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 112, \"name\" : \"Applied Mechanics\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 113, \"name\" : \"Mathematics II\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 114, \"name\" : \"Introduction to Programming\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 115, \"name\" : \"Physics of Materials\", \"credits\" : 4, \"category\" : \"H\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 116, \"name\" : \"Principles of Electrical Engg\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 117, \"name\" : \"Applied Mechanics\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 118, \"name\" : \"Introduction to Programming\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 119, \"name\" : \"Physics of Materials\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 28,\n" +
            "\t\t\"semester\" : 2\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"humanities\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 205, \"name\" : \"Mathematics III\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"applied\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 203, \"name\" : \"Power Apparatus\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 204, \"name\" : \"Electrical Measurements\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"core\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 201, \"name\" : \"Electronics I\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 202, \"name\" : \"Circuits and Systems\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 201, \"name\" : \"Electronics I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 202, \"name\" : \"Circuits and Systems\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 203, \"name\" : \"Power Apparatus\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 204, \"name\" : \"Electrical Measurements\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 205, \"name\" : \"Mathematics III\", \"credits\" : 4, \"category\" : \"H\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 206, \"name\" : \"Electronics I\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 207, \"name\" : \"Power Apparatus\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 208, \"name\" : \"Electrical Measurements\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 209, \"name\" : \"Machine Drawing\", \"credits\" : 3},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 210, \"name\" : \"Programming I\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 30,\n" +
            "\t\t\"semester\" : 3\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"humanities\" : [],\n" +
            "\t\t\t\"applied\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 212, \"name\" : \"Electromagnetic I\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"core\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 211, \"name\" : \"Electronics II\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 213, \"name\" : \"Data Structures\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 214, \"name\" : \"Digital Circuits and Systems I\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 215, \"name\" : \"Principles of Communication Engg.\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 211, \"name\" : \"Electronics II\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 212, \"name\" : \"Electromagnetics I\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 213, \"name\" : \"Data Structures\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 214, \"name\" : \"Digital Circuits and Systems I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 215, \"name\" : \"Principles of Communication Engg.\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 216, \"name\" : \"Electronics II\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 217, \"name\" : \"Digital Circuits and Systems I\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 218, \"name\" : \"Principles of Communication Engg.\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 219, \"name\" : \"Electrical Workshop and Electric Drg.\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR5\", \"code\" : 220, \"name\" : \"Practical Training\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 221, \"name\" : \"Report Writing\", \"credits\" : 1},\n" +
            "\t\t\t\t{\"sno\" : \"VS2\", \"code\" : 222, \"name\" : \"Programming II\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 32,\n" +
            "\t\t\"semester\" : 4\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"humanities\" : [],\n" +
            "\t\t\t\"applied\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 305, \"name\" : \"Industrial Org. and Mana. Eco.\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"core\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 301, \"name\" : \"Principles of Computer Graphics\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 302, \"name\" : \"Discrete Maths and Design of Alg.\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 303, \"name\" : \"Computer System Org.\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 304, \"name\" : \"Linear Integrated Circuits\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 301, \"name\" : \"Principles of Computer Graphics\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 302, \"name\" : \"Discrete Maths and Design of Alg.\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 303, \"name\" : \"Computer System Org.\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 304, \"name\" : \"Linear Integrated Circuits\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 305, \"name\" : \"Industrial Org. and Mana. Eco.\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 306, \"name\" : \"Computer System Org.\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 307, \"name\" : \"Linear Integrated Circuits\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 308, \"name\" : \"Principles of Computer Graphics\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 309, \"name\" : \"Programming III\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 27,\n" +
            "\t\t\"semester\" : 5\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"humanities\" : [],\n" +
            "\t\t\t\"applied\" : [],\n" +
            "\t\t\t\"core\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 311, \"name\" : \"Microprocessors\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 312, \"name\" : \"DBMS\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 313, \"name\" : \"OS\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 314, \"name\" : \"Control Engineering\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 315, \"name\" : \"ACA\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 311, \"name\" : \"Microprocessors\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 312, \"name\" : \"DBMS\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 313, \"name\" : \"OS\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 314, \"name\" : \"Control Engineering\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 315, \"name\" : \"ACA\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 316, \"name\" : \"Microprocessors\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 317, \"name\" : \"DBMS\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 318, \"name\" : \"Control Engineering\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 319, \"name\" : \"Programming IV\", \"credits\" : 1},\n" +
            "\t\t\t\t{\"sno\" : \"VS2\", \"code\" : 320, \"name\" : \"Practical Training\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 29,\n" +
            "\t\t\"semester\" : 6\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"humanities\" : [],\n" +
            "\t\t\t\"applied\" : [],\n" +
            "\t\t\t\"core\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 401, \"name\" : \"Compiler and Translator Design\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 402, \"name\" : \"Digital Circuits and Systems II\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 403, \"name\" : \"Microprocessor Applications\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 404, \"name\" : \"Elective I\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 405, \"name\" : \"Elective II\", \"credits\" : 4},\n" +
            "\t\t\t],\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 401, \"name\" : \"Compiler and Translator Design\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 402, \"name\" : \"Digital Circuits and Systems II\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 403, \"name\" : \"Microprocessor Applications\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 404, \"name\" : \"Elective I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 405, \"name\" : \"Elective II\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 406, \"name\" : \"Compiler and Translator Design\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 407, \"name\" : \"Digital Circuits and Systems II\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 408, \"name\" : \"Electives I and II\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 409, \"name\" : \"Practical Training\", \"credits\" : 3},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 410, \"name\" : \"System Programming Language\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 30,\n" +
            "\t\t\"semester\" : 7\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"humanities\" : [],\n" +
            "\t\t\t\"applied\" : [],\n" +
            "\t\t\t\"core\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 411, \"name\" : \"Computer Comm. and Electronics Swng.\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 412, \"name\" : \"Elective III\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 413, \"name\" : \"Elective IV\", \"credits\" : 4}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 411, \"name\" : \"Computer Comm. and Electronics Swng.\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 412, \"name\" : \"Elective III\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 413, \"name\" : \"Elective IV\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 414, \"name\" : \"Elective III and IV\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 415, \"name\" : \"Project\", \"credits\" : 8},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 416, \"name\" : \"Practical Training\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 417, \"name\" : \"Seminar/Reports\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 27,\n" +
            "\t\t\"semester\" : 8\n" +
            "\t}\n" +
            "\t],\n" +
            "\t\"ice\" : [\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 101, \"name\" : \"Humanities\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 102, \"name\" : \"Mathematics I\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 103, \"name\" : \"Physics I\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 104, \"name\" : \"Chemistry\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 105, \"name\" : \"Manufacturing Processes\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 106, \"name\" : \"Engineering Drawing T\", \"credits\" : 3},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 107, \"name\" : \"Physics I\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 108, \"name\" : \"Chemistry\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 109, \"name\" : \"Workshop I\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 29,\n" +
            "\t\t\"semester\" : 1\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 111, \"name\" : \"Principles of Electrical Engg\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 112, \"name\" : \"Applied Mechanics\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 113, \"name\" : \"Mathematics II\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 114, \"name\" : \"Introduction to Programming\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 115, \"name\" : \"Physics of Materials\", \"credits\" : 4, \"category\" : \"H\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 116, \"name\" : \"Principles of Electrical Engg\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 117, \"name\" : \"Applied Mechanics\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 118, \"name\" : \"Introduction to Programming\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 119, \"name\" : \"Physics of Materials\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 28,\n" +
            "\t\t\"semester\" : 2\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 201, \"name\" : \"Electronics I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 202, \"name\" : \"Circuits and Systems\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 203, \"name\" : \"Power Apparatus\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 204, \"name\" : \"Electrical Measurements\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 205, \"name\" : \"Mathematics III\", \"credits\" : 4, \"category\" : \"H\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 206, \"name\" : \"Electronics I\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 207, \"name\" : \"Power Apparatus\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 208, \"name\" : \"Electrical Measurements\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 209, \"name\" : \"Machine Drawing\", \"credits\" : 3},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 210, \"name\" : \"Programming I\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 30,\n" +
            "\t\t\"semester\" : 3\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 211, \"name\" : \"Electronics II\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 212, \"name\" : \"Fluid Mechanics and Thermodynamics\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 213, \"name\" : \"Electronic Instruments & Measuring Techniques\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 214, \"name\" : \"Computer Graphics\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 215, \"name\" : \"Transducers & Components\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 216, \"name\" : \"Electronics II\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 217, \"name\" : \"Computer Graphics\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 218, \"name\" : \"Instrumentation Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 219, \"name\" : \"Electrical Workshop and Electric Drg.\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR5\", \"code\" : 220, \"name\" : \"Practical Training\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 221, \"name\" : \"Report Writing\", \"credits\" : 1},\n" +
            "\t\t\t\t{\"sno\" : \"VS2\", \"code\" : 222, \"name\" : \"Programming II\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 32,\n" +
            "\t\t\"semester\" : 4\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 301, \"name\" : \"Analog and Digital Communication\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 302, \"name\" : \"Industrial and Analytical Instruments\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 303, \"name\" : \"Digital Integrated Circuits I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 304, \"name\" : \"Linear Integrated Circuits I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 305, \"name\" : \"Industrial Org. and Mana. Eco.\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 306, \"name\" : \"Analog and Digital Communication\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 307, \"name\" : \"Digital Integrated Circuits I\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 308, \"name\" : \"Linear Integrated Circuits\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 309, \"name\" : \"Programming III\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 27,\n" +
            "\t\t\"semester\" : 5\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 311, \"name\" : \"Microprocessor\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 312, \"name\" : \"Computer Aided Design\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 313, \"name\" : \"Industrial Electronics\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 314, \"name\" : \"Control Systems I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 315, \"name\" : \"Telemetry & Data Transmission\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 316, \"name\" : \"Microprocessor\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 317, \"name\" : \"CAD Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 318, \"name\" : \"Control Systems Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 319, \"name\" : \"Programming IV\", \"credits\" : 1},\n" +
            "\t\t\t\t{\"sno\" : \"VS2\", \"code\" : 320, \"name\" : \"Practical Training\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 29,\n" +
            "\t\t\"semester\" : 6\n" +
            "\t}\n" +
            "\t],\n" +
            "\t\"mpae\" : [\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 101, \"name\" : \"Humanities\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 102, \"name\" : \"Mathematics I\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 103, \"name\" : \"Physics I\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 104, \"name\" : \"Chemistry\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 105, \"name\" : \"Manufacturing Processes (Introduction)\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 106, \"name\" : \"Engineering Drawing T\", \"credits\" : 3},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 107, \"name\" : \"Physics I\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 108, \"name\" : \"Chemistry\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 109, \"name\" : \"Workshop I\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 29,\n" +
            "\t\t\"semester\" : 1\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 111, \"name\" : \"Electrical Sciences\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 112, \"name\" : \"Mathematics II\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 113, \"name\" : \"Mechanical Sciences\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 114, \"name\" : \"Sciecnce of Materials\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 115, \"name\" : \"Mechanics of Solids\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 116, \"name\" : \"Electrical Science Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 117, \"name\" : \"Mechanical Sciences Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 118, \"name\" : \"Introduction to Computer Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 119, \"name\" : \"Mecanics of Solids Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 120, \"name\" : \"Programming I Lab\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 29,\n" +
            "\t\t\"semester\" : 2\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 201, \"name\" : \"Machine Drawing and Graphics\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 202, \"name\" : \"Manufacturing Processes I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 203, \"name\" : \"Electro mechanics\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 204, \"name\" : \"Analog and Digital Electronics\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 205, \"name\" : \"Technology and Society\", \"credits\" : 4, \"category\" : \"H\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 206, \"name\" : \"Machine Drawing and Graphics Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 207, \"name\" : \"Science of Materials and Manufacturing Processes I Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 208, \"name\" : \"Electro Mechanics Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 209, \"name\" : \"Analog and Digital Electronics Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 210, \"name\" : \"Programming I Lab\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 29,\n" +
            "\t\t\"semester\" : 3\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 211, \"name\" : \"Kinematics and Dynamics of Machinery\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 212, \"name\" : \"Control Systems\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 213, \"name\" : \"Mathematics III\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 214, \"name\" : \"Manufacturing Processes II\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 215, \"name\" : \"Management of Manufacturing Systems\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 216, \"name\" : \"Kinematics and Dynamics of Machinery Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 217, \"name\" : \"Control Systems Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 218, \"name\" : \"Manufacturing Processes II Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 219, \"name\" : \"Practical Training\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 220, \"name\" : \"Report Writing\", \"credits\" : 1},\n" +
            "\t\t\t\t{\"sno\" : \"VS2\", \"code\" : 221, \"name\" : \"Programming II\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 30,\n" +
            "\t\t\"semester\" : 4\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 301, \"name\" : \"Machine Tools, CNC & Automation\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 302, \"name\" : \"Transducers and Measurements\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 303, \"name\" : \"Tool Design\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 304, \"name\" : \"Industrial Control Systems\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 305, \"name\" : \"Microprocessors and Applications\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 306, \"name\" : \"Machine Tools Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 307, \"name\" : \"Tool Design Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 308, \"name\" : \"MA 304 based Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 308, \"name\" : \"Transducers and Measurements Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 309, \"name\" : \"Programming III\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 29,\n" +
            "\t\t\"semester\" : 5\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 311, \"name\" : \"Robotics and CAM I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 312, \"name\" : \"Computer Graphics\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 313, \"name\" : \"Applied Plasticity (Forming Processes)\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 314, \"name\" : \"Mechanical Design\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 315, \"name\" : \"Metroloay & Statistical Quality Control\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 316, \"name\" : \"Robotics and CAM I Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 317, \"name\" : \"MA312 based Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 318, \"name\" : \"Forming Processes Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 319, \"name\" : \"Mechanical Design\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 320, \"name\" : \"Practical Training\", \"credits\" : 1},\n" +
            "\t\t\t\t{\"sno\" : \"VS2\", \"code\" : 320, \"name\" : \"Programming V\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 30,\n" +
            "\t\t\"semester\" : 6\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 401, \"name\" : \"Introduction to CAD and Product Design\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 402, \"name\" : \"Modern Methods of Manufacturing\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 403, \"name\" : \"Industrial Electronics\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 404, \"name\" : \"Elective I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 405, \"name\" : \"Elective II\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 406, \"name\" : \"CAD Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 407, \"name\" : \"Modern Methods of Manufacturing Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 408, \"name\" : \"Industrial Electronics Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 409, \"name\" : \"Practical Training\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 410, \"name\" : \"Programming IV (AUTOCAD)\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 29,\n" +
            "\t\t\"semester\" : 7\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 411, \"name\" : \"Macaronis or AI\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 412, \"name\" : \"Elective III\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 413, \"name\" : \"Elective IV\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 414, \"name\" : \"MA 411 based Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 415, \"name\" : \"Elective III and IV Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 416, \"name\" : \"Project\", \"credits\" : 8},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 417, \"name\" : \"Practical Training\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 418, \"name\" : \"Seminar and Reports\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 27,\n" +
            "\t\t\"semester\" : 8\n" +
            "\t}\n" +
            "\t],\n" +
            "\t\"ece\" :[\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 101, \"name\" : \"Humanities\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 102, \"name\" : \"Mathematics I\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 103, \"name\" : \"Physics I\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 104, \"name\" : \"Chemistry\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 105, \"name\" : \"Manufacturing Processes\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 106, \"name\" : \"Engineering Drawing Lab\", \"credits\" : 3},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 107, \"name\" : \"Physics I Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 108, \"name\" : \"Chemistry Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 109, \"name\" : \"Workshop I\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 29,\n" +
            "\t\t\"semester\" : 1\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 111, \"name\" : \"Principles of Electrical Engg\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 112, \"name\" : \"Applied Mechanics\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 113, \"name\" : \"Mathematics II\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 114, \"name\" : \"Physics II\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 115, \"name\" : \"Electrical Engineering and Materials\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 116, \"name\" : \"Principles of Electrical Engg. Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 117, \"name\" : \"Applied Mechanics Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 118, \"name\" : \"Physics II/Electrical Engg Materials Lab\", \"credits\" : 4},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 119, \"name\" : \"Workshop II\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 30,\n" +
            "\t\t\"semester\" : 2\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 201, \"name\" : \"Electronics I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 202, \"name\" : \"Circuits and Systems\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 203, \"name\" : \"Electrical Machines I\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 204, \"name\" : \"Electrical Measurements\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 205, \"name\" : \"Mathematics III\", \"credits\" : 4, \"category\" : \"H\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 206, \"name\" : \"Electronics I Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 207, \"name\" : \"Electrical Machines I Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 208, \"name\" : \"Electrical Measurements Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 209, \"name\" : \"Machine Drawing\", \"credits\" : 3},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 210, \"name\" : \"Programming I\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 30,\n" +
            "\t\t\"semester\" : 3\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 211, \"name\" : \"Electronics II\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 212, \"name\" : \"Electromagnetics\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 213, \"name\" : \"Network Analysis and Synthesis\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 214, \"name\" : \"Digital Circuits and Systems I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 215, \"name\" : \"Electrical Machines II\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 216, \"name\" : \"Electronics II Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 217, \"name\" : \"Digital Circuits and Systems I Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 218, \"name\" : \"Electrical Machines II Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 219, \"name\" : \"Electrical Workshop and Electric Drg.\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR5\", \"code\" : 220, \"name\" : \"Practical Training\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 221, \"name\" : \"Report Writing\", \"credits\" : 1},\n" +
            "\t\t\t\t{\"sno\" : \"VS2\", \"code\" : 222, \"name\" : \"Programming II\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 32,\n" +
            "\t\t\"semester\" : 4\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 301, \"name\" : \"Transmission Lines\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 302, \"name\" : \"Control Engineering\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 303, \"name\" : \"Computer System Org.\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 304, \"name\" : \"LIC\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 305, \"name\" : \"Industrial Org. and Managerial Eco.\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 306, \"name\" : \"Computer System Org. Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 307, \"name\" : \"LIC Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 308, \"name\" : \"Control Engineering Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 309, \"name\" : \"Programming III\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 27,\n" +
            "\t\t\"semester\" : 5\n" +
            "\t}\n" +
            "\t],\n" +
            "\t\"bt\" : [\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 101, \"name\" : \"Humanities\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 102, \"name\" : \"Mathematics I\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 103, \"name\" : \"Physics I\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 104, \"name\" : \"Chemistry\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 105, \"name\" : \"Manufacturing Processes\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 106, \"name\" : \"Engineering Drawing Lab\", \"credits\" : 3},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 107, \"name\" : \"Physics I Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 108, \"name\" : \"Chemistry Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 109, \"name\" : \"Workshop I\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 29,\n" +
            "\t\t\"semester\" : 1\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 111, \"name\" : \"Introduction to Biotechnology\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 112, \"name\" : \"Physics II\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 113, \"name\" : \"Chemistry II\", \"credits\" : 4, \"category\" : \"H\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 114, \"name\" : \"Mechanical Sciences\", \"credits\" : 4, \"category\" : \"A\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 115, \"name\" : \"Engineering Mathematics\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 116, \"name\" : \"Introduction to Biotech Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 117, \"name\" : \"Physics II Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 118, \"name\" : \"Chemistry II/Electrical Engg Materials Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 119, \"name\" : \"Mechanical Sciences Lab\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 28,\n" +
            "\t\t\"semester\" : 2\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 201, \"name\" : \"Cell Biology\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 202, \"name\" : \"Biochemistry\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 203, \"name\" : \"Microbiology\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 204, \"name\" : \"Basics of Computer Systems and Programming\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 205, \"name\" : \"Basic Electronics and Instrumentation\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 206, \"name\" : \"Cell Biology Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 207, \"name\" : \"Biochemistry and Microbiology Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 208, \"name\" : \"Basics of Computer Systems and Programming Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 209, \"name\" : \"Basic Electronics and Instrumentation Lab\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 28,\n" +
            "\t\t\"semester\" : 3\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 211, \"name\" : \"Molecular Biology\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 212, \"name\" : \"Genetics\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 213, \"name\" : \"Methods and Instrumentation in Biotechnology\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 214, \"name\" : \"Statistics for Biology\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 215, \"name\" : \"Data Structures and Algorithms\", \"credits\" : 4, \"category\" : \"C\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 216, \"name\" : \"Molecular Biology and Genetics Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 217, \"name\" : \"Methods and Instrumentation in Biotechnology Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 218, \"name\" : \"Data Structures Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 219, \"name\" : \"Project\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 28,\n" +
            "\t\t\"semester\" : 4\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 301, \"name\" : \"Structural Biology\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 302, \"name\" : \"Immunology and Immuno-technology\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 303, \"name\" : \"Recombinant-DNA Technology I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 304, \"name\" : \"DBMS\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 305, \"name\" : \"Chemical Engineering Principles\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 306, \"name\" : \"Structural Biology Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 307, \"name\" : \"Immunology and Immuno-technology Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 308, \"name\" : \"Recombinant-DNA Technology I Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 309, \"name\" : \"DBMS Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"VS1\", \"code\" : 310, \"name\" : \"Term Paper and Seminar\", \"credits\" : 2}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 30,\n" +
            "\t\t\"semester\" : 5\n" +
            "\t},\n" +
            "\t{\n" +
            "\t\t\"subjects\" : {\n" +
            "\t\t\t\"theory\" : [\n" +
            "\t\t\t\t{\"sno\" : \"TH1\", \"code\" : 311, \"name\" : \"Recombinant-DNA Technology II\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH2\", \"code\" : 312, \"name\" : \"Enzymology and Enzyme Technology\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH3\", \"code\" : 313, \"name\" : \"Plant and Animal Biotechnology\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH4\", \"code\" : 314, \"name\" : \"Computational Biology I\", \"credits\" : 4, \"category\" : \"C\"},\n" +
            "\t\t\t\t{\"sno\" : \"TH5\", \"code\" : 315, \"name\" : \"Fundamentals of Biochemical Engineering\", \"credits\" : 4, \"category\" : \"A\"}\n" +
            "\n" +
            "\t\t\t],\n" +
            "\t\t\t\"practical\" : [\n" +
            "\t\t\t\t{\"sno\" : \"PR1\", \"code\" : 316, \"name\" : \"Recombinant-DNA Technology II Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR2\", \"code\" : 317, \"name\" : \"Enzymology and Enzyme Technology Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR3\", \"code\" : 318, \"name\" : \"Plant and Animal Biotechnology Lab\", \"credits\" : 2},\n" +
            "\t\t\t\t{\"sno\" : \"PR4\", \"code\" : 319, \"name\" : \"Computational Biology I Lab\", \"credits\" : 1}\n" +
            "\t\t\t]\n" +
            "\t\t},\n" +
            "\t\t\"totalCredits\" : 28,\n" +
            "\t\t\"semester\" : 6\n" +
            "\t}\n" +
            "\t]\n" +
            "}";


    String pro = "[\n" +
            "  {\n" +
            "    \"Header\": \"DEPARTMENT OF MANAGEMENT\",\n" +
            "    \"ContentArray\": [\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Pankaj Deshwal\",\n" +
            "        \"Designation\": \"\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"25000162(DID) , 3162(Int)\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Header\": \"DEPARTMENT OF CHEMISTRY\",\n" +
            "    \"ContentArray\": [\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Sanjeev Thakur\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"sanjeevthakur@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"25000239(DID) , 3239(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr.(Mrs.)Anjana Sarkar\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"anjana@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"25000240(DID) , 3240(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr.(Mrs.)Purnima Jain\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"purnima@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"25000172(DID) , 3172(Int)\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Header\": \"DEPARTMENT OF PHYSICS\",\n" +
            "    \"ContentArray\": [\n" +
            "      {\n" +
            "        \"Name\": \"Prof. O.P.Thakur\",\n" +
            "        \"Designation\": \"Professor\",\n" +
            "        \"Email\": \"opthakur@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"25000190(DID) , 3190(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr.(Mrs.)Ranjana Jha\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"ranjana@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"25000221(DID), 3221(Int)\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Header\": \"DEPARTMENT OF MATHEMATICS\",\n" +
            "    \"ContentArray\": [\n" +
            "      {\n" +
            "        \"Name\": \"Prof. Vijay Gupta\",\n" +
            "        \"Designation\": \"Professor\",\n" +
            "        \"Email\": \"vijay@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"25000245(DID) , 3245(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr.J.K.Misra\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"jkmishra@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"25000009(DID) , 3009(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Jasobanta Jena\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"jjena@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"25000229(DID) , 3229\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr.(Mrs.)Mamta Misra\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"mmishra@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"25000214(DID) , 3214(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. J.K. Singh\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"jksingh@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"25000248(DID), 3248(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Neeraj Srivastava\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"25000207(DID) , 3207(Int)\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Header\": \"School Of Humanities & Management\",\n" +
            "    \"ContentArray\": [\n" +
            "      {\n" +
            "        \"Name\": \"Dr. (Mrs.) Tanushree Choudhary (English)\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"tanushree@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"25000257(DID), 3257 (Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr.(Mrs.) Duru Arun Kumar (Sociology)\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"darun@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Prasanta Kumar Bhuyan (Sociology\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"25000023(DID) , 3023(Int)\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Header\": \"Division of Electronics and Communications Engineering\",\n" +
            "    \"ContentArray\": [\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Maneesha Gupta\",\n" +
            "        \"Designation\": \"Professor & Head\",\n" +
            "        \"Email\": \"maneesha@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Harish Parthasarathy\",\n" +
            "        \"Designation\": \"Professor\",\n" +
            "        \"Email\": \"harishp@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Raj Senani\",\n" +
            "        \"Designation\": \"Professor\",\n" +
            "        \"Email\": \"senani@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"91-11-25099035\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Sujata Sengar\",\n" +
            "        \"Designation\": \"Associate Professor & Associate Head\",\n" +
            "        \"Email\": \"sujata@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Dharmendra Kumar Upadhyay\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Parul Garg\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"parul@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Shree Prakash Singh\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"spsingh@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Dhananjay Vasudeo Gadre\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"dvgadre@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Tarun Kumar Rawat\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"tarun@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Jyotsna Singh\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"jyotsna@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Shailesh Mishra\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Ankur Bansal\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"25000089(DID), 3089(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Bhawna Aggarwal\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"25000092(DID) 3092(Int.)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Urvashi Bansal\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"25000093(DID) 3093(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Kunwar Singh\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"25000091(DID), 3091(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Shweta Gautam\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Header\": \"Division of Computer Engineering\",\n" +
            "    \"ContentArray\": [\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Shampa Chakraverty\",\n" +
            "        \"Designation\": \"Professor & Head\",\n" +
            "        \"Email\": \"shampa@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Satish Chand\",\n" +
            "        \"Designation\": \"Professor\",\n" +
            "        \"Email\": \"satish@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. M.P.S. Bhatia\",\n" +
            "        \"Designation\": \"Professor\",\n" +
            "        \"Email\": \"mpsbhatia@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Sangeeta Sabharwal\",\n" +
            "        \"Designation\": \"Professor\",\n" +
            "        \"Email\": \"ssab@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Rajiv Kumar\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Satbir Jain\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"sjain@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Savita Yadav\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Vijeta Mehra\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Poonam Rani\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Bijendra Kumar\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"bijender@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Khushil Kr. Saini\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"khushil@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Preeti Kaur\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"preeti@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Sushma Nagpal\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"sushma@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Anand Gupta\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"anand.gupta@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Veenu\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"veenu@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. (Ms) Ritu Sibal\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"rsb@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. (Mrs.) Swati Aggarwal\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"25000102(DID), 3102(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Pinaki Chkraborty\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"25000096(DID), 3096(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms.Vidhi Khanduja\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"25000104(DID), 3104(Int)\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Header\": \"Division of Instrumentation and Control Engineering\",\n" +
            "    \"ContentArray\": [\n" +
            "      {\n" +
            "        \"Name\": \"Dr. A.P. Mittal\",\n" +
            "        \"Designation\": \"Professor & Head\",\n" +
            "        \"Email\": \"headice@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. (Ms.) Smriti Srivastava\",\n" +
            "        \"Designation\": \"Professor\",\n" +
            "        \"Email\": \"smriti@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. J.R.P. Gupta\",\n" +
            "        \"Designation\": \"Professor\",\n" +
            "        \"Email\": \"jrpgupta@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. (Ms.) Prerna Gaur\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"prernagaur@yahoo.com\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Vijander Singh\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Asha Rani\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"asha.rani@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. K.P.S. Rana\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"kpsrana@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. R.C. Thakur\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"rct@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Amar Nath Jha\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"anjha@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Rajneesh Sharma\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"rajneesh@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Vicky Suri\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"vicky@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Shyama Kant Jha\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"skjha@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. (Ms.) Pragya Varshney\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"pragya@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Vineet Kumar\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"vineet@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Piyush Saxena\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"piyush@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Bhavnesh Kumar\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"bhavnesh.kumar@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Jyoti Yadav\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"jyoti.yadav@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"25000079(DID), 3079(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Manisha\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"manisha.singh@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"25000080(DID), 3080(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Anil Sangwan\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"anil.sangwan@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Hasmat\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"hasmat.malik@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"25000083(DID), 3083(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Swaroop D.\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"dswaroop@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Header\": \"Division of Manufacturing Processes and Automation\",\n" +
            "    \"ContentArray\": [\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Sachin Maheshwari\",\n" +
            "        \"Designation\": \"Professor & Head\",\n" +
            "        \"Email\": \"sachin@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Sanjay Kumar Chak\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"skchak@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Dinesh Kumar Singh\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"dksingh@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Pramendra Kumar Bajpai\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"pramendra.bajpai@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Manish Kumar\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"manish.kumar@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Arvind Meena\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"arvind.meena@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Narender Kumar\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"narender.kumar@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Andriya Narasimhulu\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"andriya@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Umang Soni\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"umang.soni@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. C.S. Verma\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"csverma@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Aditya Kumar\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"aditya@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Pradeep Khanna\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"pradeep@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. A.V. Muley\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"avmuley@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Sanjay Gupta\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"sgupta@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. S.K. Jha\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"shailendra@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Vijayant Aggarwal\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"vijayant@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Abhishek Tevatia\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"abhishek.tevatia@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Header\": \"Division of Information Technology\",\n" +
            "    \"ContentArray\": [\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Sanjay Kumar Dhurandher\",\n" +
            "        \"Designation\": \"Associate Professor & Associate Head\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Devender Kumar\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Amarjit Malhotra\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Ankita Jain Bansal\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Deepika Kukreja\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Deepak Kumar Sharma\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Vikas Marotras\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Samayveer Singh\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Preeti Bansal\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Apoorvi Sood\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Sangeeta Sabharwal\",\n" +
            "        \"Designation\": \"Head\",\n" +
            "        \"Email\": \"ssab@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Header\": \"Division of Bio-Technology\",\n" +
            "    \"ContentArray\": [\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Ashok Kumar Dubey\",\n" +
            "        \"Designation\": \"Professor & Head\",\n" +
            "        \"Email\": \"akdubey@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. (Ms.) Sonika Bhatnagar\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"sbhatnagar@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. (Ms.) Shilpa Sharma\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Akhilesh Dubey\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"25000101(DID), 3101(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Sanjeev Kumar\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"25000088(DID), 3088(Int)\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Soumya Sasmal\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Vishal Mishra\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Yatendra Kumar\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Satish Kumar Singh\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Ms. Akanksha Kulshreshtha\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Sh. Ajay Kumar Kataria\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      }\n" +
            "    ]\n" +
            "  },\n" +
            "  {\n" +
            "    \"Header\": \"School of Applied Science\",\n" +
            "    \"ContentArray\": [\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Vijay Gupta\",\n" +
            "        \"Designation\": \"Professor\",\n" +
            "        \"Email\": \"vijay@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Om Prakash Thakur\",\n" +
            "        \"Designation\": \"Professor\",\n" +
            "        \"Email\": \"opthakur@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Mamta Mishra\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"mmishra@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Jasobanta Jena\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"jjena@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. J.K. Misra\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"jkmishra@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Sanjeev Thakur\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"sanjeevthakur@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. (Ms.) Ranjana Jha\",\n" +
            "        \"Designation\": \"Associate Professor\",\n" +
            "        \"Email\": \"ranjana@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Neeraj Kumar\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"neeraj@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. J.K. Singh\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"jksingh@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr.(Ms.) Purnima Jain\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"purnima@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. (Ms.) Anjana Sarkar\",\n" +
            "        \"Designation\": \"Assistant Professor\",\n" +
            "        \"Email\": \"anjana@nsit.ac.in\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"Name\": \"Dr. Vijay Gupta\",\n" +
            "        \"Designation\": \"Head\",\n" +
            "        \"Email\": \"\",\n" +
            "        \"ContactNo\": \"\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";

}
