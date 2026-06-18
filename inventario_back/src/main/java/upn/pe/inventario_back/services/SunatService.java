package upn.pe.inventario_back.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SunatService implements ConsultaRucService {

    private final RestTemplate restTemplate;

    public SunatService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String consultarRuc(String ruc) {
        String url = "https://api.apis.net.pe/v2/sunat/ruc?numero=" + ruc;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "$apis-token-11533.dQwdSyb6046QMR9tK5PTu8brPGLl8ynl");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getBody();
    }
}