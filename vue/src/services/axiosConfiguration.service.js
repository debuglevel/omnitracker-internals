import { authenticationService } from "../services/authentication.service";
import axios from "axios";

export const axiosConfigurationService = {
  getAxiosRequestConfig,
};

function getBaseUrl() {
  console.info("Getting Base URL...");

  return (
    axios
      .get("settings.json")
      //.then(response => (this.baseUrl = response.data.baseUrl));
      .then((response) => {
        console.info(`Got baseUrl=${response.data.baseUrl} from settings.json`);
        return response.data.baseUrl;
      })
  );
}

async function getAxiosRequestConfig() {
  console.info("Getting AxiosRequestConfig...");

  let auth = authenticationService.authConfig().auth;

  let baseUrl = await getBaseUrl();
  console.info(`Using baseUrl=${baseUrl} for AxiosRequestConfig.baseURL`);

  let config = {
    baseURL: baseUrl,
    auth: auth,
  };

  console.info(`Using AxiosRequestConfig:`);
  console.info(config);
  return config;
}
