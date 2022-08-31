# using jenv to set jdk (https://www.jenv.be/)
echo "Set java to 17.0.3"
jenv global 17.0.3
echo "build pdf_native_service"
./mvnw clean package -Pnative -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true -Dmaven.test.skip=true -Dquarkus.profile=native
