package dev.tobiadegbuji.donut.backend.donut_shop_backend.exception;


import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {

    private final String resourceName;

    public ResourceNotFoundException(Long id, String resourceName) {
        super(resourceName + " with ID: " + id + " was not found");
        this.resourceName = resourceName;
    }
}
