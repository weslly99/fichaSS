package br.edu.sededosaber.fichasededosaber.bd;

/**
 * Created by weslly on 07/02/16.
 */
public class SchemeDb {

    public final static class CertificateTable {
        public static final String NAME = "cerfitificate";

        public final static class Cols {
            public static final String UUID = "uuid_certificate";
            public static final String NAME = "name";
            public static final String NAME_FATHER = "name_father";
            public static final String NAME_MOTHER = "name_mother";
            public static final String BIRTH_DAY = "birh_day";
            public static final String CITY = "city";
            public static final String STATE = "state";
            public static final String NOTARY_OFFICE = "notary_office";
            public static final String BOOK = "book";
            public static final String NUMBER = "number";
        }
    }

    public static final class ContactTable {
        public static final String NAME = "contact";

        public static final class Cols {
            public static final String UUID = "uuid_contact";
            public static final String PHONE = "phone";
            public static final String STATE = "state";
            public static final String CITY = "city";
            public static final String NEIGHBORHOOD = "neighborhood";
            public static final String STREET = "street";
            public static final String NUMBER = "number";
        }
    }

    public static final class DocsTable {
        public static final String NAME = "docs";

        public static final class Cols {
            public static final String UUID = "uuid_docs";
            public static final String CPF_FATHER = "cpf_father";
            public static final String RG_FATHER = "rg_father";
            public static final String CPF_MOTHER = "cpf_mother";
            public static final String RG_MOTHER = "rg_mother";

        }
    }

    public static final class RecordTable {
        public static final String NAME = "record";

        public static final class Cols {
            public static final String UUID = "uuid_record";
            public static final String ID_DOCS = "id_docs";
            public static final String ID_CERTIFICATE = "id_certificate";
            public static final String ID_CONTACT = "id_contact";
            public static final String ID_CLASSROM = "id_classroom";
        }
    }


    public static final class ClassroomTable {
        public static final String NAME = "classroom";

        public static final class Cols {
            public static final String UUID = "uuid_classroom";
            public static final String SHIFT = "shift";
            public static final String NAME = "name_classroom";
        }
    }

}
