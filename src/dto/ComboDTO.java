package dto;

public class ComboDTO {
    private Integer id;
    private String dic_val;

    @Override
    public String toString() {
        return "ComboDTO{" +
                "id=" + id +
                ", dic_val='" + dic_val + '\'' +
                '}';
    }

    public ComboDTO(Integer id, String dic_val) {
        this.id = id;
        this.dic_val = dic_val;
    }

    public ComboDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDic_val() {
        return dic_val;
    }

    public void setDic_val(String dic_val) {
        this.dic_val = dic_val;
    }
}
