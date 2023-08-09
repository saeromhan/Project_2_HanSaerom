package com.example.project7.dto;

@Data
public class UserDto {
    private Long id;
    private String title;
    private String description;
    // UserDto.java
    public static UserDto fromEntity(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        // ... 기타 필요한 필드 설정
        return dto;
    }
