package in.saffu.exceptionresponse;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

	public String message;

	public Boolean sucess;

	public LocalDate date;

	public int status;

}
