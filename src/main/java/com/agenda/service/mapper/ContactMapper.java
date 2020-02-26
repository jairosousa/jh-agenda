package com.agenda.service.mapper;


import com.agenda.domain.*;
import com.agenda.service.dto.ContactDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Contact} and its DTO {@link ContactDTO}.
 */
@Mapper(componentModel = "spring", uses = {UsuarioMapper.class})
public interface ContactMapper extends EntityMapper<ContactDTO, Contact> {

    @Mapping(source = "email.id", target = "emailId")
    @Mapping(source = "username.id", target = "usernameId")
    ContactDTO toDto(Contact contact);

    @Mapping(source = "emailId", target = "email")
    @Mapping(source = "usernameId", target = "username")
    Contact toEntity(ContactDTO contactDTO);

    default Contact fromId(Long id) {
        if (id == null) {
            return null;
        }
        Contact contact = new Contact();
        contact.setId(id);
        return contact;
    }
}
