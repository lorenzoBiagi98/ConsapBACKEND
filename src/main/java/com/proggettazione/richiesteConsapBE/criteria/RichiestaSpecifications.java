package com.proggettazione.richiesteConsapBE.criteria;

import com.proggettazione.richiesteConsapBE.model.Richiesta;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.Predicate
import java.util.function.Predicate;

public class RichiestaSpecifications {

    public static Specification<Richiesta> withFilters(
            String numeroTicket,
            String applicativo,
            String oggetto,
            String statoRichiestaCONSAP,
            String statoApprovazioneCONSAP,
            String statoRichiestaOS,
            String statoApprovazioneOS
    ) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (numeroTicket != null && !numeroTicket.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("numeroTicket"), numeroTicket));
            }

            if (applicativo != null && !applicativo.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("applicativo"), applicativo));
            }

            if (oggetto != null && !oggetto.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("oggetto"), oggetto));
            }

            if (statoRichiestaCONSAP != null && !statoRichiestaCONSAP.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("statoRichiestaCONSAP"), statoRichiestaCONSAP));
            }

            if (statoApprovazioneCONSAP != null && !statoApprovazioneCONSAP.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("statoApprovazioneCONSAP"), statoApprovazioneCONSAP));
            }

            if (statoRichiestaOS != null && !statoRichiestaOS.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("statoRichiestaOS"), statoRichiestaOS));
            }

            if (statoApprovazioneOS != null && !statoApprovazioneOS.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("statoApprovazioneOS"), statoApprovazioneOS));
            }

            return predicate;
        };
    }
}

