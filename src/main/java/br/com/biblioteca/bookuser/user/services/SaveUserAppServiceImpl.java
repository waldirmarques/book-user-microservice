package br.com.biblioteca.bookuser.user.services;

import br.com.biblioteca.bookuser.user.UserApp;
import br.com.biblioteca.bookuser.user.UserAppRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class SaveUserAppServiceImpl implements SaveUserAppService {

    private final UserAppRepository userAppRepository;

    @Override
    public void insert(UserApp userApp) {
        userApp.setSpecificID(UUID.randomUUID().toString());
        userAppRepository.save(userApp);
    }
}
