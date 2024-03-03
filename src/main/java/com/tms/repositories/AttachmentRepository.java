package com.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.entities.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Integer>{

}
