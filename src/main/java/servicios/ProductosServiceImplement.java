package servicios;

import modelos.Productos;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Arrays;

public class ProductosServiceImplement implements ProductoService{
    @Override
    public List<Productos> listar() {
        return Arrays.asList (new Productos(1,"Laptop","computacion",100.00),
         new Productos(1,"Laptop","computacion",100.00),
         new Productos(1,"Laptop","computacion",100.00));

    }
}
