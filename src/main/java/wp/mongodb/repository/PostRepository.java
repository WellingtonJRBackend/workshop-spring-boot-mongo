package wp.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import wp.mongodb.domain.Post;
import wp.mongodb.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
