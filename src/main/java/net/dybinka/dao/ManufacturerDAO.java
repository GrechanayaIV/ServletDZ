package net.dybinka.dao;

import net.dybinka.model.Manufacturer;

import java.util.UUID;

public interface ManufacturerDAO extends GenericDAO<Manufacturer, UUID> {
    Manufacturer getByName(String name);
}
