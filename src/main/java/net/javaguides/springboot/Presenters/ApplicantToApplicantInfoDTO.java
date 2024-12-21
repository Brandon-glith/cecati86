package net.javaguides.springboot.Presenters;

import org.springframework.stereotype.Component;

import net.javaguides.springboot.DTO.ApplicantInfoDTO;
import net.javaguides.springboot.Models.Applicant;

@Component
public class ApplicantToApplicantInfoDTO
        implements InterfaceEntityToDTOMapper<ApplicantInfoDTO, Applicant> {

    @Override
    public ApplicantInfoDTO convertToDTO(Applicant applicant) {
        ApplicantInfoDTO applicantInfoDTO = new ApplicantInfoDTO();
        applicantInfoDTO.setId(applicant.getId());
        applicantInfoDTO.setName(applicant.getName());
        applicantInfoDTO.setSurnames(applicant.getLastName());
        applicantInfoDTO.setEmail(applicant.getEmail());
        applicantInfoDTO.setPassword(applicant.getPassword());
        applicantInfoDTO.setBirthdate(applicant.getBirthdate());
        applicantInfoDTO.setPhoneNumber(applicant.getPhoneNumber());
        applicantInfoDTO.setCreationDate(applicant.getCreationDate());
        return applicantInfoDTO;
    }

}
