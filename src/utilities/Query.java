package utilities;

public enum Query {
    COMBO_DATAS("select * from dictionary where dic_key = ?"),
    ADD_STUDENT("insert into students (id,name,surname,email,gender,dictionary_id,phone,password) values (student_id_seq.nextval,?,?,?,?,?,?,?)"),
    ADD_STUDENT_ROLE("insert into role_to_student values (role_id_seq.nextval,?,?)"),
    SELECT_STUDENT_ROLE("select r.id, r.name from role_to_student rts inner join roles r on r.id = rts.role_id inner join students s on s.id = RTS.STUDENT_ID where RTS.STUDENT_ID = ?"),
    LOG_IN_STUDENT("select id,name,surname from students where email=? and password=? and (state=2 or state=3)"),
    ADD_CONFIRM_KEY("insert into confirm_keys values (confirm_key_id.nextval,?,?)"),
    SELECT_STUDENT_BY_CONFIRM_KEY("select user_id from confirm_keys where confirm_key = ?"),
    APPROVAL_STUDENT_APPEAL("update students set state = 2 where id = ?"),
    SELECT_STUDENT_NAME("select name,gender from students where id = ?"),
    SELECT_STUDENTS_FROM_DB("select s.id,rownum,s.name,s.surname,s.email,s.phone,d.dic_val from students s join dictionary d on S.DICTIONARY_ID=D.ID where state = 2"),
    SELECT_MODERATORS_FROM_DB("select s.id,rownum,s.name,s.surname,s.email,R.NAME,r.id from students s join dictionary d on S.DICTIONARY_ID=D.ID join role_to_student rts on RTS.STUDENT_ID = s.id join roles r on RTS.ROLE_ID = r.id where RTS.ROLE_ID=1 or RTS.ROLE_ID=2"),
    SELECT_STUDENT_FROM_DB_BY_ID("select s.id,rownum,s.name,s.surname,s.email,s.phone,d.dic_val,s.gender,d.id from students s join dictionary d on S.DICTIONARY_ID=D.ID where s.id = ?"),
    REMOVE_STUDENT("delete from students where id = ?"),
    REMOVE_MODERATOR("delete from role_to_student where student_id=? and role_id=?"),
    UPDATE_STUDENT("update students set name = ?,surname = ?,email = ?,gender = ?,dictionary_id = ?,phone = ? where id = ?");


    String query;

    Query(String s) {
        query = s;
    }

    public String getQuery() {
        return query;
    }
}
