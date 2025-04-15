//package it.smartworki.dating_app.services;
//
//import it.smartworki.dating_app.entities.Preference;
//import it.smartworki.dating_app.entities.User;
//import it.smartworki.dating_app.exceptions.notFound.UserNotFoundException;
//import it.smartworki.dating_app.repositories.PreferenceRepository;
//import it.smartworki.dating_app.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PreferenceService {
//    private PreferenceRepository preferenceRepository;
//    private UserRepository userRepository;
//
//    @Autowired
//    public PreferenceService(PreferenceRepository preferenceRepository, UserRepository userRepository) {
//        this.preferenceRepository = preferenceRepository;
//        this.userRepository = userRepository;
//    }
//
//    // findById
//    public Preference findById(Long id) {
//        return preferenceRepository.findById(id).
//                orElseThrow(() -> new UserNotFoundException(id));
//    }
//
//    // save
//    public Preference save(Preference preference) {
//        // Verifica che l'utente esista
//        User user = userRepository.findById(preference.getId())
//                .orElseThrow(() -> new UserNotFoundException(preference.getId()));
//
//        // Verifica che lo user non abbia già una precedenza
//        if(user.getPreference() != null)
//            throw new PreferenceAlreadyExistsException();  // Da implementare
//
//        // Setta l'utente nella preferenza
//        preference.setUser(user);
//
//        return preferenceRepository.save(preference);
//    }
//
//    // updateById
//}