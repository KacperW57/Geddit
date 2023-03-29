import { DataState } from './../enum/data-state.enum';
export interface AppState<T> {
  DataState: DataState;
  appData?: T;
  error?: string;
}
