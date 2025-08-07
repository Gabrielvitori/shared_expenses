package model;

public class DivisaoDespesa {
    private Usuario usuario;
    private double valorDevido;
    private boolean foiPago;

    public DivisaoDespesa(Usuario usuario, double valorDevido) {
        this.usuario = usuario;
        this.valorDevido = valorDevido;
        this.foiPago = false;
    }

    public void marcarComoPago() {
        this.foiPago = true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getValorDevido() {
        return valorDevido;
    }
}
