package library.mappers;

import org.springframework.stereotype.Component;

import library.dto.ReaderGetDto;
import library.entities.Reader;

@Component
public class ReaderMapper {

    public Reader map(ReaderGetDto reader){
        return new Reader(
                    reader.getFullName(),
                    reader.getPassportNumber(),
                    reader.getPhone()
        );
    }

}
