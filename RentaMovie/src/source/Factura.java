package source;

import java.sql.Date;

public class Factura {
    
    private int id_factura, id_cliente, id_vendedor, total;
    private Date fecha_entrega, fecha_devolucion;
    
    public Factura(){
        
    }

    public Factura(int id_factura, int id_cliente, int id_vendedor, int total, Date fecha_entrega, Date fecha_devolucion) {
        this.id_factura = id_factura;
        this.id_cliente = id_cliente;
        this.id_vendedor = id_vendedor;
        this.total = total;
        this.fecha_entrega = fecha_entrega;
        this.fecha_devolucion = fecha_devolucion;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }
    
    
    
}
