package net.dybinka;

import net.dybinka.dao.ManufacturerDAO;
import net.dybinka.dao.ProductDAO;
import net.dybinka.dao.hibernate.ManufacturerDAOImpl;
import net.dybinka.dao.hibernate.ProductDAOImpl;

public class DaoSingleton {
    private ManufacturerDAO manufacturerDAO;
    private ProductDAO productDAO;
    private static final DaoSingleton INSTANCE = new DaoSingleton();

    private DaoSingleton() {
        manufacturerDAO = new ManufacturerDAOImpl();
        productDAO = new ProductDAOImpl();
    }

    public ManufacturerDAO getManufacturerDAO() {
        return manufacturerDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public static DaoSingleton getINSTANCE() {
        return INSTANCE;
    }
}
