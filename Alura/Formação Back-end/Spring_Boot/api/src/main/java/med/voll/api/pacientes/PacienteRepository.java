package med.voll.api.pacientes;

import med.voll.api.pacientes.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}