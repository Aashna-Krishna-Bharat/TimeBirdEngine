package com.keyur.timebirdengine.service;

import com.keyur.timebirdengine.dto.DoctorResponseDto;
import com.keyur.timebirdengine.dto.OnboardDoctorRequestDto;
import com.keyur.timebirdengine.entity.Doctor;
import com.keyur.timebirdengine.entity.User;
import com.keyur.timebirdengine.entity.type.RoleType;
import com.keyur.timebirdengine.repository.DoctorRepository;
import com.keyur.timebirdengine.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public List<DoctorResponseDto> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(doctor -> modelMapper.map(doctor, DoctorResponseDto.class))
                .collect(Collectors.toList());
    }


    @Transactional
    public DoctorResponseDto onBoardNewDoctor(OnboardDoctorRequestDto onBoardDoctorRequestDto) {
        User user = userRepository.findById(onBoardDoctorRequestDto.getUserId()).orElseThrow();

        if(doctorRepository.existsById(onBoardDoctorRequestDto.getUserId())) {
            throw new IllegalArgumentException("Already a doctor");
        }

        Doctor doctor = Doctor.builder()
                .name(onBoardDoctorRequestDto.getName())
                .specialization(onBoardDoctorRequestDto.getUserRole())
                .user(user)
                .build();

        user.getRoles().add(RoleType.WORKER);

        return modelMapper.map(doctorRepository.save(doctor), DoctorResponseDto.class);
    }
}
