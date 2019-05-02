package types;

public enum SituacaoType {
 
    ATIVO("Ativo"),
    INATIVO("Inativo");

    private String value;

    private SituacaoType(String value) {
        setValue(value);
    }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

}
