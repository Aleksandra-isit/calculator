
import controllers.UserController;
import model.FileOperation;
import model.FileOperationImpl;
import model.Repository;
import model.RepositoryImpl;
import view.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("users.txt");
        Repository repository = new RepositoryImpl(fileOperation);
        UserController controller = new UserController(repository);
        ViewUser view = new ViewUser(controller);
        view.calculate();
    }
}