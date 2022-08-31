# using jenv to set jdk (https://www.jenv.be/)
echo "Set java to 17.0.3"
jenv global 17.0.3
echo "build pdf_jvm_service"
./mvnw clean package -Dquarkus.container-image.build=true -Dmaven.test.skip=true -Dquarkus.profile=docker
