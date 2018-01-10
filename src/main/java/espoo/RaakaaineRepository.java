package espoo;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

// This is the repository interface, this will be automatically implemented by Spring in a bean
// with the same name with changing case The bean name will be raakaaineRepository
// This will be AUTO IMPLEMENTED by Spring into a Bean called raakaaineRepository
// CRUD refers Create, Read, Update, Delete
// https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/
// --> CrudRepository.html

    // public interface RaakaaineRepository extends JpaRepository<Ruoka, Integer> {
    public interface RaakaaineRepository extends CrudRepository<Ruoka, Integer> {


        // Repon metodien luomiset https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-creation
        // find…By, read…By, query…By, count…By, get…By tai reop.save() löytyvät oletuksena ja jos niiden lisäksi halutaan jotain toiminnallisuutta,
        // niin sitten interfaceen kirjoitetaan omia hakuja


    }


