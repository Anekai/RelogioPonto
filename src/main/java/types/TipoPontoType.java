
package types;

public enum TipoPontoType {
    
    ENTRADA("Entrada"),
    SAIDA("Saída");

    private String value;

    private TipoPontoType(String value) {
        setValue(value);
    }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    
}
