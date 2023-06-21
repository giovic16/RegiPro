package com.regipro.backend.service;

import com.regipro.backend.model.RegiProModel;
import com.regipro.backend.repository.RegiProRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegiProService {
    private final RegiProRepository regiProRepository;

    public RegiProService(RegiProRepository regiProRepository) {
        this.regiProRepository = regiProRepository;
    }

    public RegiProModel criaUsuario(RegiProModel usuario){
        RegiProModel regiProModel = regiProRepository.findByEmail(usuario.getEmail());
        if (regiProModel != null) {
            throw new RuntimeException("Email já cadastrado!");
        }
        return regiProRepository.save(usuario);
    }

    public List<RegiProModel> getAllUsers() {
        return regiProRepository.findAll();
    }

    public RegiProModel getUserById(Long id) {
        return regiProRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void updateUser(RegiProModel updatedUser) {
        if (!regiProRepository.existsById(updatedUser.getId())) {
            throw new RuntimeException("Usuário não encontrado");
        }
        regiProRepository.save(updatedUser);
    }

    public void deleteUser(Long id) {
        if (!regiProRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        regiProRepository.deleteById(id);
    }
}
